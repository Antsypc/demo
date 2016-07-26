package xyz.antsgroup.demo.spring.transaction.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import xyz.antsgroup.demo.spring.transaction.entity.Category;

import java.sql.*;

/**
 * Spring JDBC DAO CRUD 示例
 *
 * 使用 JdbcTemplate 进行底层数据操作.
 *
 * Created by Ants Young on 2016/7/17.
 */
@Repository("categoryDao")
public class CategoryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //================= 增 update() ====================
    // 使用批量加的时候并不会自动把批次分几个块插入,如果需要把大量数据分多个次插入应该自己指定 List 的大小

    /**
     * 使用 JdbcTemplate 插入数据的一般方法
     * @param name 分类名称
     * @param parent 父类 ID
     * @return 插入条数
     */
    public int addCategory(String name, int parent) {
        String sql = "INSERT INTO category(name, parent) VALUE(?, ?)";
        return jdbcTemplate.update(sql, name, parent);
    }

    /**
     * 使用 JdbcTemplate 配合 PreparedStatementSetter 回调,插入数据的一般方法
     * @param name 分类名称
     * @param parent 父类 ID
     * @return 插入条数
     */
    public int addCategoryWithCallback(final String name, final int parent) {
        String sql = "INSERT INTO category(name, parent) VALUE(?, ?)";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, parent);
            }
        });
    }

    /**
     * 使用 JdbcTemplate 配合 PreparedStatementCreator 回调,插入数据的一般方法
     * @param name 分类名称
     * @param parent 父类 ID
     * @return 插入条数
     */
    public int addCategoryWithCallback2(final String name, final int parent) {
        final String sql = "INSERT INTO category(name, parent) VALUE(?, ?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, parent);
                return ps;
            }
        });
    }

    /**
     * 使用 JdbcTemplate 插入一条数据,并获取生成的主键.
     * 配合 update(PreparedStatementCreator psc, final KeyHolder generatedKeyHolder)
     * 单一主键: getKey();
     * 复合主键: Map<String, Object> getKeys();
     * 多个主键: List<Map<String, Object>> getKeyList();
     *
     * 如果使用原生方法,三步:
     * statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)
     * ResultSet rs = statement.getGeneratedKeys();
     * if (rs.next()) key = rs.getInt();
     *
     * @param name 分类名称
     * @param parent 父类 ID
     * @return 插入条数
     */
    public int addCategoryGetKey(final String name, final int parent) {
        final String sql = "INSERT INTO category(name, parent) VALUE(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setInt(2, parent);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    //================= 删 update() ====================


    //================= 改 update() ====================


    //================= 查 query() ====================
    /**
     * 根据分类 id 获取分类对象
     * 使用 jdbcTemplate 的 void query(String sql, Object[] args, RowCallbackHandler rch)
     * RowCallbackHandler processRow() 处理一条记录,如果需要处理多行记录需要手动加入 List 变量
     *
     * 如果需要返回 List 使用 <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper)
     * RowMapper 可以处理多条记录,自动加入 List 返回,如果返回数据量过大,可能导致数据全部加载到内存,内存泄露.
     *
     * @param id 分类 id
     * @return Category
     */
    public Category getCategoryById(final int id) {
        String sql = "SELECT * FROM category WHERE categoryId = ?";
        final Category category = new Category();
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                category.setCategoryId(id);
                category.setName(resultSet.getString("name"));
                category.setParent(resultSet.getInt("parent"));
            }
        });
        return category;
    }

    //================= 调用存储过程 execute() ====================
}
