package com.bootdo.boy.dao;

import com.bootdo.boy.domain.AdminDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
/**
 * 后台管理员账号
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
@Mapper
public interface AdminMapper {

	@Select("select `id`, `username`, `pwd`, `mtime`, `utime`, `delete_it` from admin where id = #{id}")
	AdminDO get(Long id);
	@Select("select  `username` from admin where id = #{id}")
	String getName(Long id);
	@Select("<script>" +
	"select * from admin " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username like '%${username}%' " + "</if>" +
		  		  "<if test=\"pwd != null and pwd != ''\">"+ "and pwd = #{pwd} " + "</if>" + 
		  		  "<if test=\"mtime != null and mtime != ''\">"+ "and mtime = #{mtime} " + "</if>" + 
		  		  "<if test=\"utime != null and utime != ''\">"+ "and utime = #{utime} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<AdminDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from admin " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username like '%${username}%' " + "</if>" +
		  		  "<if test=\"pwd != null and pwd != ''\">"+ "and pwd = #{pwd} " + "</if>" + 
		  		  "<if test=\"mtime != null and mtime != ''\">"+ "and mtime = #{mtime} " + "</if>" + 
		  		  "<if test=\"utime != null and utime != ''\">"+ "and utime = #{utime} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into admin (`username`, `pwd`)"
	+ "values (#{username}, #{pwd})")
	int save(AdminDO admin);
	
	@Update("<script>"+ 
			"update admin " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"username != null\">`username` = #{username}, </if>" +
                    "<if test=\"pwd != null\">`pwd` = #{pwd}, </if>" + 
                    "<if test=\"mtime != null\">`mtime` = #{mtime}, </if>" + 
                    "<if test=\"utime != null\">`utime` = #{utime}, </if>" + 
                    "<if test=\"deleteIt != null\">`delete_it` = #{deleteIt}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(AdminDO admin);
	
	@Delete("delete from admin where id =#{id} and username != 'admin'")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from admin where username != 'admin' and id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
