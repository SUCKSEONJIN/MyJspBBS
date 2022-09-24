package web.bbs.repository.shop;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import web.bbs.domain.ShopImg;

@Repository
@RequiredArgsConstructor
public class MybatisShopImgRepository implements ShopImgRepository{

	private final ShopImgMapper mapper;
		
	@Override
	public void save(ShopImg shopImg) {		
		mapper.save(shopImg);
	}

	@Override
	public void update(Long id, ShopImg shopImg) {
		mapper.update(id, shopImg);		
	}

	@Override
	public Optional<ShopImg> findById(Long id) {
		return mapper.findById(id);		
	}

	@Override
	public List<ShopImg> findAll() {
		return mapper.findByAll();
		
	}
	
	
}
