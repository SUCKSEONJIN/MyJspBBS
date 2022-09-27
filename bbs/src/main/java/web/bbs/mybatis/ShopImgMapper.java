package web.bbs.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import web.bbs.domain.ShopImg;

@Mapper
public interface ShopImgMapper {
	public void save(ShopImg img);
	public void update(@Param("id") Long id, @Param("shopImg") ShopImg shopImg);
	public Optional<ShopImg> findById(Long id);
	public List<ShopImg> findByAll();
}
