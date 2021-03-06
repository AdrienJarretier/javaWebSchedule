package model;

import model.entities.*;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class LessonDAO {
    
    private final DataSource myDataSource;
    
    private static final String LESSON_TABLE = "lesson";
    private static final String PARTICIPANTS_TABLE = "lesson_participants";
    
    public LessonDAO() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    /**
     * insert a new lesson in the database
     *
     * @return the id of the inserted row
     * @throws java.sql.SQLException
     */
    public int add(Timestamp time_start, Timestamp time_end, String title, int class_room_id, int teacher_id, ArrayList<Degree> participants) throws SQLException {
        String sql = "INSERT INTO " + LESSON_TABLE
                + "(time_start, time_end, title, class_room_id, teacher_id)"
                + " VALUES (?,?,?,?,?)";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setTimestamp(1, time_start);
        stmt.setTimestamp(2, time_end);
        stmt.setString(3, title);
        stmt.setInt(4, class_room_id);
        stmt.setInt(5, teacher_id);
        stmt.execute();
        
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        
        int generatedId = 0;
        
        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);
        }
        
        generatedKeys.close();
        stmt.close();
        connection.close();
        
        (new Lesson_participantsDAO()).add(participants, generatedId);
        
        return generatedId;
    }

    /**
     * delete the lesson with the specified id
     *
     * @param lessonId the id of the lesson to delete
     * @throws java.sql.SQLException
     */
    public void remove(int lessonId) throws SQLException {
        
        (new Lesson_participantsDAO()).remove(lessonId);
        
        String sql = "DELETE FROM " + LESSON_TABLE + " WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, lessonId);
        stmt.execute();
        stmt.close();
        
        connection.close();
    }

    /**
     * delete the lesson happening at time_start in class_room
     *
     * @param time_start
     * @param class_room
     * @throws java.sql.SQLException
     */
    public void remove(Timestamp time_start, Class_room class_room) throws SQLException {
        String sql = "SELECT id FROM " + LESSON_TABLE + " WHERE time_start = ? and class_room_id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setTimestamp(1, time_start);
        stmt.setInt(2, class_room.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        int id = -1;
        
        if (rs.next()) {
            
            id = rs.getInt(1);
            
        }
        
        stmt.close();
        connection.close();
        
        remove(id);
    }

    /**
     * delete the lesson happening at time_start with teacher
     *
     * @param time_start
     * @param teacher
     * @throws java.sql.SQLException
     */
    public void remove(Timestamp time_start, Staff teacher) throws SQLException {
        String sql = "SELECT id FROM " + LESSON_TABLE + " WHERE time_start = ? and teacher_id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setTimestamp(1, time_start);
        stmt.setInt(2, teacher.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        int id = -1;
        
        if (rs.next()) {
            
            id = rs.getInt(1);
            
        }
        
        stmt.close();
        connection.close();
        
        remove(id);
    }

    /**
     * update lesson in the database looks for the id of the lesson and update
     * all the columns for that record to match the lesson entity attributes
     *
     * @param lesson the lesson to be recorded
     * @throws java.sql.SQLException
     */
    public void edit(Lesson lesson) throws SQLException {
        String sql = "UPDATE " + LESSON_TABLE + " SET time_start = ?, "
                + " time_end = ?, "
                + " title = ?, "
                + " class_room_id = ?, "
                + " teacher_id = ?"
                + " WHERE id = ? ";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setTimestamp(1, lesson.getTimeStart());
        stmt.setTimestamp(2, lesson.getTimeEnd());
        stmt.setString(3, lesson.getTitle());
        stmt.setInt(4, lesson.getClass_room().getId());
        stmt.setInt(5, lesson.getTeacher().getId());
        stmt.setInt(6, lesson.getId());
        stmt.execute();
        
        stmt.execute();
        stmt.close();
        connection.close();

        // delete all lesson_participant for that lesson id
        // then for each participants we will add those participants
        Lesson_participantsDAO parts = new Lesson_participantsDAO();
        
        parts.remove(lesson.getId());
        
        parts.add(lesson.getParticipants(), lesson.getId());
    }

    /**
     *
     * @param lesson_id
     * @return
     * @throws SQLException
     * @throws DAOException
     */
    public Lesson getById(int lesson_id) throws SQLException, DAOException {
        
        String sql
                = " SELECT * FROM " + LESSON_TABLE
                + " WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, lesson_id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            
            int id = rs.getInt(1);
            Timestamp start = rs.getTimestamp("time_start");
            Timestamp end = rs.getTimestamp("time_end");
            String title = rs.getString("title");
            int class_room_id = rs.getInt("class_room_id");
            int teacher_id = rs.getInt("teacher_id");
            
            Class_room class_room = (new Class_roomDAO()).getById(class_room_id);
            Staff teacher = (new StaffDAO()).getById(teacher_id);
            ArrayList<Degree> participants = (new Lesson_participantsDAO()).getParticipants(lesson_id);
            
            Lesson lesson = new Lesson(id, start, end, title, class_room, teacher, participants);
            
            rs.close();
            stmt.close();
            connection.close();
            
            return lesson;
            
        } else {
            
            rs.close();
            stmt.close();
            connection.close();
            
            throw new DAOException("this id does not match any lesson");
            
        }
    }
    
    private ArrayList<Lesson> getLessons(PreparedStatement stmt) throws SQLException {
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Lesson> lessons = new ArrayList<>();
        
        while (rs.next()) {
            
            int lesson_id = rs.getInt(1);
            Timestamp start = rs.getTimestamp("time_start");
            Timestamp end = rs.getTimestamp("time_end");
            String title = rs.getString("title");
            
            int class_room_id = rs.getInt("class_room_id");
            String building = rs.getString("building");
            int room_nb = rs.getInt("room_nb");
            int capacity = rs.getInt("capacity");
            
            Class_room class_room = new Class_room(class_room_id, building, room_nb, capacity);
            
            int teacher_id = rs.getInt("teacher_id");;
            String email = rs.getString("email");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            
            Staff teacher = new Staff(teacher_id, email, first_name, last_name, Boolean.FALSE);
            
            lessons.add(new Lesson(lesson_id, start, end, title, class_room, teacher, (new Lesson_participantsDAO()).getParticipants(lesson_id)));
            
        }
        
        rs.close();
        
        return lessons;
    }

    /**
     *
     * get the complete scheduler
     *
     * @return the list of all the lessons, past and future
     * @throws java.sql.SQLException
     */
    public ArrayList<Lesson> getSchedule() throws SQLException {
        
        String sql
                = " SELECT * FROM " + LESSON_TABLE
                + " INNER JOIN class_room ON class_room.id=LESSON.CLASS_ROOM_ID "
                + " INNER JOIN staff ON staff.id=LESSON.TEACHER_ID "
                + " ORDER BY time_start";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ArrayList<Lesson> lessons = getLessons(stmt);
        
        stmt.close();
        connection.close();
        
        return lessons;
    }

    /**
     *
     * get the schedule of a teacher
     *
     * @param teacher the teacher we want the lessons of
     * @return the list of all the lessons of a teacher
     * @throws java.sql.SQLException
     */
    public ArrayList<Lesson> getSchedule(Staff teacher) throws SQLException {
        
        String sql
                = " SELECT * FROM " + LESSON_TABLE
                + " INNER JOIN class_room ON class_room.id=LESSON.CLASS_ROOM_ID "
                + " INNER JOIN staff ON staff.id=LESSON.TEACHER_ID "
                + " WHERE teacher_id = ? "
                + " ORDER BY time_start";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, teacher.getId());
        
        ArrayList<Lesson> lessons = getLessons(stmt);
        
        stmt.close();
        connection.close();
        
        return lessons;
        
    }

    /**
     *
     * get the schedule of a degree
     *
     * @param degree the degree we want the lessons of
     * @return the list of all the lessons of a degree
     * @throws java.sql.SQLException
     */
    public ArrayList<Lesson> getSchedule(Degree degree) throws SQLException, DAOException {
        
        String sql
                = " SELECT id FROM " + LESSON_TABLE
                + " INNER JOIN " + PARTICIPANTS_TABLE + " ON " + LESSON_TABLE + ".id = " + PARTICIPANTS_TABLE + ".lesson_id "
                + " WHERE degree_id = ? "
                + " ORDER BY time_start";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, degree.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Lesson> lessons = new ArrayList<>();
        
        while (rs.next()) {
            
            int lesson_id = rs.getInt(1);
            
            lessons.add(getById(lesson_id));
            
        }
        
        rs.close();
        
        stmt.close();
        connection.close();
        
        return lessons;
        
    }
    
}
