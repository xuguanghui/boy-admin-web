package com.bootdo.boy.dao;

import com.bootdo.boy.domain.SchoolDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
/**
 * 学校表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
@Mapper
public interface SchoolMapper {

	@Select("select `id`, `longitude`, `latitude`, `name`, `address`, `delete_it`, `user_add`, `modify` from school where id = #{id}")
	SchoolDO get(Long id);
	
	@Select("<script>" +
	"select * from school " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"longitude != null and longitude != ''\">"+ "and longitude = #{longitude} " + "</if>" + 
		  		  "<if test=\"latitude != null and latitude != ''\">"+ "and latitude = #{latitude} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name like '%${name}%' " + "</if>" +
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and user_add = #{userAdd} " + "</if>" + 
		  		  "<if test=\"modify != null and modify != ''\">"+ "and modify = #{modify} " + "</if>" + 
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
@Results({
		@Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
		@Result(property ="userAddname",column="user_add"
				,one =@One(select ="com.bootdo.boy.dao.AdminMapper.getName")),
		@Result(property ="modifyname",column="modify"
				,one =@One(select ="com.bootdo.boy.dao.AdminMapper.getName"))
})
	List<SchoolDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from school " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"longitude != null and longitude != ''\">"+ "and longitude = #{longitude} " + "</if>" + 
		  		  "<if test=\"latitude != null and latitude != ''\">"+ "and latitude = #{latitude} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name like '%${name}%'" + "</if>" +
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and user_add = #{userAdd} " + "</if>" + 
		  		  "<if test=\"modify != null and modify != ''\">"+ "and modify = #{modify} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into school (`longitude`, `latitude`, `name`, `address`,`delete_it`, `user_add`, `modify`)"
	+ "values (#{longitude}, #{latitude}, #{name}, #{address}, #{deleteIt}, #{userAdd}, #{modify})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int save(SchoolDO school);
	
	@Update("<script>"+ 
			"update school " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"longitude != null\">`longitude` = #{longitude}, </if>" + 
                    "<if test=\"latitude != null\">`latitude` = #{latitude}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"address != null\">`address` = #{address}, </if>" + 
                    "<if test=\"deleteIt != null\">`delete_it` = #{deleteIt}, </if>" + 
                    "<if test=\"userAdd != null\">`user_add` = #{userAdd}, </if>" + 
                    "<if test=\"modify != null\">`modify` = #{modify}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(SchoolDO school);
	
	@Delete("delete from school where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from school where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
