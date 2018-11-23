
package com.bootdo.boy.dao;

import com.bootdo.boy.domain.SchoolTrainerDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
/**
 * 学校教练关联表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-23 12:50:01
 */
@Mapper
public interface SchoolTrainerMapper {

	@Select("select `school_id`, `trainer_id`, `delete_it`, `user_add`, `modify` from school_trainer where school_id = #{id}")
	SchoolTrainerDO get(Long schoolId);
	
	@Select("<script>" +
	"select * from school_trainer " + 
			"<where>" + 
		  		  "<if test=\"schoolId != null and schoolId != ''\">"+ "and school_id = #{schoolId} " + "</if>" + 
		  		  "<if test=\"trainerId != null and trainerId != ''\">"+ "and trainer_id = #{trainerId} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and user_add = #{userAdd} " + "</if>" + 
		  		  "<if test=\"modify != null and modify != ''\">"+ "and modify = #{modify} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by school_id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SchoolTrainerDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from school_trainer " + 
			"<where>" + 
		  		  "<if test=\"schoolId != null and schoolId != ''\">"+ "and school_id = #{schoolId} " + "</if>" + 
		  		  "<if test=\"trainerId != null and trainerId != ''\">"+ "and trainer_id = #{trainerId} " + "</if>" + 
		  		  "<if test=\"deleteIt != null and deleteIt != ''\">"+ "and delete_it = #{deleteIt} " + "</if>" + 
		  		  "<if test=\"userAdd != null and userAdd != ''\">"+ "and user_add = #{userAdd} " + "</if>" + 
		  		  "<if test=\"modify != null and modify != ''\">"+ "and modify = #{modify} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("<script>" + "insert into school_trainer <trim prefix='(' suffix=')' suffixOverrides=',' >" +         "<if test=\"schoolId != null\">`school_id` , </if>" +
        "<if test=\"trainerId != null\">`trainer_id` , </if>" +
        "<if test=\"deleteIt != null\">`delete_it` , </if>" +
        "<if test=\"userAdd != null\">`user_add` , </if>" +
        "<if test=\"modify != null\">`modify` , </if>" +
 "</trim><trim prefix='values (' suffix=')' suffixOverrides=',' >"
	+         "<if test=\"schoolId != null\">#{schoolId}, </if>" +
        "<if test=\"trainerId != null\">#{trainerId}, </if>" +
        "<if test=\"deleteIt != null\">#{deleteIt}, </if>" +
        "<if test=\"userAdd != null\">#{userAdd}, </if>" +
        "<if test=\"modify != null\">#{modify}, </if>" +
 "</trim></script>")
	int save(SchoolTrainerDO schoolTrainer);
	
	@Update("<script>"+ 
			"update school_trainer " + 
					"<set>" + 
		            "<if test=\"schoolId != null\">`school_id` = #{schoolId}, </if>" + 
                    "<if test=\"trainerId != null\">`trainer_id` = #{trainerId}, </if>" + 
                    "<if test=\"deleteIt != null\">`delete_it` = #{deleteIt}, </if>" + 
                    "<if test=\"userAdd != null\">`user_add` = #{userAdd}, </if>" + 
                    "<if test=\"modify != null\">`modify` = #{modify}, </if>" + 
          					"</set>" + 
					"where school_id = #{schoolId}"+
			"</script>")
	int update(SchoolTrainerDO schoolTrainer);
	
	@Delete("delete from school_trainer where school_id =#{schoolId}")
	int remove(Long school_id);
	
	@Delete("<script>"+ 
			"delete from school_trainer where school_id in " + 
					"<foreach item=\"schoolId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{schoolId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] schoolIds);
}
