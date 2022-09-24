package web.bbs.repository.shop;

import java.util.List;
import java.util.Optional;


import web.bbs.domain.ShopImg;


public interface ShopImgRepository {
	
	public void save(ShopImg shopImg);
	public void update(Long id, ShopImg shopImg);
	public Optional<ShopImg> findById(Long id);
	public List<ShopImg> findAll();
	
	
	
}
