package web.bbs.repository.shop;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import web.bbs.domain.ShopImg;

public interface ShopImgMybatisAnnotationRepository extends ShopImgRepository{

	@Override
	@Insert("insert shop_img_repository into (ref, userId) values(#{ref}), #{userId})") 
	public void save(ShopImg shopImg);

	@Override
	@Update("update shop_img_repository set ref=#{ref}, userId=#{userId}")
	public void update(@Param("id") Long id, @Param("shopImg") ShopImg shopImg);
	

	@Override	
	@Select("select * from shop_img_repository where id=#{id}")
	public Optional<ShopImg> findById(Long id);
	
	@Override
	@Select("select * from shop_img_repository")
	public List<ShopImg> findAll(); 
	
}
