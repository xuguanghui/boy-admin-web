
package com.bootdo.boy.dao;

import com.bootdo.boy.domain.TrainerDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
/**
 * 教练表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-22 21:17:42
 */
@Mapper
public interface TrainerMapper {

	@Select("select `id`, `name`, `short_desc`, `pic`, `user_add`, `modify`, `delete_it`, `mobile` from trainer where id = #{id}")
	TrainerDO get(Long id);
	
	@Select("<script>" +
	"select tr.*,sc.`name` as schoolName FROM trainer  tr LEFT JOIN school_trainer st on tr.id=st.trainer_id LEFT JOIN school sc on st.school_id=sc.id " +
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and tr.id = #{id} " + "</if>" +
		  		  "<if test=\"name != null and name != ''\">"+ "and tr.name like '%${name}%' " + "</if>" +
		  		  "<if test=\"shortDesc != null and shortDesc != ''\">"+ "and tr.short_desc = #{shortDesc} " + "</if>" +
		  		  "<if test=\"pic != null and pic != ''\">"+ "and tr.pic = #{pic} " + "</if>" +
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and tr.user_add = #{userAdd} " + "</if>" +
		  		  "<if test=\"modify != null and modify != ''\">"+ "and tr.modify = #{modify} " + "</if>" +
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and tr.delete_it = #{deleteIt} " + "</if>" +
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and tr.mobile = #{mobile} " + "</if>" +
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
					,one =@One(select ="com.bootdo.boy.dao.AdminMapper.getName")),
			@Result(property ="schoolName",column="schoolName")
	})
	List<TrainerDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from trainer " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name like '%${name}%' " + "</if>" +
		  		  "<if test=\"shortDesc != null and shortDesc != ''\">"+ "and short_desc = #{shortDesc} " + "</if>" + 
		  		  "<if test=\"pic != null and pic != ''\">"+ "and pic = #{pic} " + "</if>" + 
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and user_add = #{userAdd} " + "</if>" + 
		  		  "<if test=\"modify != null and modify != ''\">"+ "and modify = #{modify} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("<script>" + "insert into trainer " +
			"<trim prefix='(' suffix=')' suffixOverrides=',' >" +
        "<if test=\"name != null\">`name` , </if>" +
        "<if test=\"shortDesc != null\">`short_desc` , </if>" +
        "<if test=\"pic != null\">`pic` , </if>" +
        "<if test=\"userAdd != null\">`user_add` , </if>" +
        "<if test=\"modify != null\">`modify` , </if>" +
        "<if test=\"deleteIt != null\">`delete_it` , </if>" +
        "<if test=\"mobile != null\">`mobile` , </if>" +
			"</trim><trim prefix='values (' suffix=')' suffixOverrides=',' >" +
        "<if test=\"name != null\">#{name}, </if>" +
        "<if test=\"shortDesc != null\">#{shortDesc}, </if>" +
        "<if test=\"pic != null\">#{pic}, </if>" +
        "<if test=\"userAdd != null\">#{userAdd}, </if>" +
        "<if test=\"modify != null\">#{modify}, </if>" +
        "<if test=\"deleteIt != null\">#{deleteIt}, </if>" +
        "<if test=\"mobile != null\">#{mobile}, </if>" +
 "</trim></script>")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int save(TrainerDO trainer);
	
	@Update("<script>"+ 
			"update trainer " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"shortDesc != null\">`short_desc` = #{shortDesc}, </if>" + 
                    "<if test=\"pic != null\">`pic` = #{pic}, </if>" + 
                    "<if test=\"userAdd != null\">`user_add` = #{userAdd}, </if>" + 
                    "<if test=\"modify != null\">`modify` = #{modify}, </if>" + 
                    "<if test=\"deleteIt != null\">`delete_it` = #{deleteIt}, </if>" + 
                    "<if test=\"mobile != null\">`mobile` = #{mobile}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(TrainerDO trainer);
	
	@Delete("delete from trainer where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from trainer where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
