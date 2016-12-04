package model;

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

    public LessonDAO() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    /**
     * insert a new lesson in the database
     *
     * @return the id of the inserted row
     * @throws java.sql.SQLException
     */
    public int add(Timestamp time_start, Timestamp time_end, String title, int class_room_id, int teacher_id) throws SQLException {
        String sql = "INSERT INTO " + LESSON_TABLE
                + "(time_start, time_end, title, class_room_id, teacher_id)"
                + "VALUES (?,?,?,?,?)";

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

        return generatedId;
    }

    /**
     * delete the lesson with the specified id
     *
     * @param lessonId the id of the lesson to delete
     * @throws java.sql.SQLException
     */
    public void remove(int lessonId) throws SQLException {
        String sql = "DELETE FROM " + LESSON_TABLE + " WHERE ID = ?";

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
        String sql = "DELETE FROM " + LESSON_TABLE + " WHERE time_start = ? and class_room_id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTimestamp(1, time_start);
        stmt.setInt(2, class_room.getId());
        stmt.execute();
        stmt.close();
        connection.close();
    }

    /**
     * delete the lesson happening at time_start with teacher
     *
     * @param time_start
     * @param teacher
     * @throws java.sql.SQLException
     */
    public void remove(Timestamp time_start, Staff teacher) throws SQLException {
        String sql = "DELETE FROM " + LESSON_TABLE + " WHERE time_start = ? and teacher_id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTimestamp(1, time_start);
        stmt.setInt(2, teacher.getId());
        stmt.execute();
        stmt.close();
        connection.close();
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
                + "time_end = ?, "
                + "title = ?, "
                + "class_room_id = ?, "
                + "teacher_id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTimestamp(1, lesson.getTimeStart());
        stmt.setTimestamp(2, lesson.getTimeEnd());
        stmt.setString(3, lesson.getTitle());
        stmt.setInt(4, lesson.getClass_room_id());
        stmt.setInt(5, lesson.getTeacher_id());
        stmt.execute();

        stmt.execute();
        stmt.close();
        connection.close();
    }

    /**
     * 
     * @param lesson_id
     * @return
     * @throws SQLException
     * @throws DAOException 
     */
    public Lesson getById(int lesson_id) throws SQLException, DAOException {

        String sql = "SELECT * FROM " + LESSON_TABLE + " WHERE id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, lesson_id);
        ResultSet rs = stmt.executeQuery();

        Lesson lesson = null;

        if (rs.next()) {

            int id = rs.getInt("id");
            Timestamp start = rs.getTimestamp("time_start");
            Timestamp end = rs.getTimestamp("time_end");
            String title = rs.getString("title");
            int class_room_id = rs.getInt("class_room_id");
            int teacher_id = rs.getInt("teacher_id");

            lesson = new Lesson(id, start, end, title, class_room_id, teacher_id);

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

    /**
     *
     * get the schedule of a teacher
     *
     * @param time_start
     * @param time_end
     * @param teacher
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Staff teacher) throws SQLException {

        int teacher_id = teacher.getId();

        String sql = "SELECT * FROM " + LESSON_TABLE + " WHERE time_start >= ? and time_end <= ? and teacher_id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTimestamp(1, time_start);
        stmt.setTimestamp(2, time_end);
        stmt.setInt(3, teacher_id);
        ResultSet rs = stmt.executeQuery();

        ArrayList<Lesson> lessons = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            Timestamp start = rs.getTimestamp("time_start");
            Timestamp end = rs.getTimestamp("time_end");
            String title = rs.getString("title");
            int class_room_id = rs.getInt("class_room_id");

            lessons.add(new Lesson(id, start, end, title, class_room_id, teacher_id));

        }

        rs.close();
        stmt.close();
        connection.close();

        return lessons;

    }

    /**
     *
     * get the schedule for a degree
     *
     * @param time_start
     * @param time_end
     * @param degree
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Degree degree) {

    }

    /**
     *
     * get the schedule of a class room
     *
     * @param time_start
     * @param time_end
     * @param class_room
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Class_room class_room) {

    }
}
