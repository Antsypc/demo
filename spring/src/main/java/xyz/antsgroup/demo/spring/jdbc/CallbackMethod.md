使用JdbcTemplate查询的三种回调
===================
用于查询的回调接口定义主要有以下三种：

## org.springframework.jdbc.core.ResultSetExtractor.  
基本上属于JdbcTemplate内部使用的Callback接口,相对于下面两个Callback接口来说,ResultSetExtractor拥有更多的控制权,
因为使用它,你需要自行处理ResultSet：
```java
public interface ResultSetExtractor
{
	Object extractData(ResultSet rs) throws SQLException, DataAccessException;
}
```

在直接处理完ResultSet之后,你可以将处理后的结果以任何你想要的形式包装后返回.

## org.springframework.jdbc.core.RowCallbackHandler.  
RowCallbackHandler相对于ResultSetExtractor来说,仅仅关注单行结果的处理,处理后的结果可以根据需要存放到当前RowCallbackHandler对象内
或者使用JdbcTemplate的程序上下文中,当然,这个完全是看个人爱好了. RowCallbackHandler的定义如下：
```java
public interface RowCallbackHandler
{
	void processRow(ResultSet rs) throws SQLException;
}
```


# org.springframework.jdbc.core.RowMapper.  
ResultSetExtractor的精简版,功能类似于RowCallbackHandler,也只关注处理单行的结果,不过,处理后的结果会由ResultSetExtractor实现类进行组合.
RowMapper的接口定义如下：
```
public interface RowMapper
{
	Object mapRow(ResultSet rs, int rowNum) throws SQLException;
}
```

---------------------------------------------------------------------------

为了说明这三种Callback接口的使用和相互之间的区别,我们暂且设定如下场景：
数据库表customer中存在多行信息,对该表查询后,我们需要将每一行的顾客信息都映射到域对象Customer中,并以java.util.List的形式返回所有的查询结果.
现在,我们分别使用这三种Callback接口对customer表进行查询：

ResultSetExtractor
```java
List customerList = (List)jdbcTemplate.query("select * from customer", new ResultSetExtractor(){

	public Object extractData(ResultSet rs) throws SQLException,DataAccessException
	{
		List customers = new ArrayList();
		while(rs.next())
		{
			Customer customer = new Customer();
			customer.setFirstName(rs.getString(1));
			customer.setLastName(rs.getString(2));
			...
			customers.add(customer);
		}
		return customers;
	}});
```

RowMapper
```java
List customerList = jdbcTemplate.query("select * from customer", new RowMapper(){

	public Object mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Customer customer = new Customer();
		customer.setFirstName(rs.getString(1));
		customer.setLastName(rs.getString(2));
		...
		return customer;
	}});
```

RowCallbackHandler
```java
final List customerList = new ArrayList();

jdbcTemplate.query("select * from customer", new RowCallbackHandler(){

	public void processRow(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		customer.setFirstName(rs.getString(1));
		customer.setLastName(rs.getString(2));
		...
		customerList.add(customer);
	}});
```

使用三种Callback接口作为参数的query方法的返回值不同:
以ResultSetExtractor作为方法参数的query方法返回Object型结果,要使用查询结果,我们需要对其进行强制转型；
以RowMapper接口作为方法参数的query方法直接返回List型的结果；
以RowCallbackHandler作为方法参数的query方法,返回值为void；
使用ResultSetExtractor作为Callback接口处理查询结果,我们需要自己声明集合类,自己遍历ResultSet,自己根据每行数据组装Customer对象,
自己将组装后的Customer对象添加到集合类中,方法最终只负责将组装完成的集合返回.
