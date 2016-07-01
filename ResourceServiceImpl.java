package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RsourceDaoImpl;
import com.model.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private RsourceDaoImpl dao;
	@Override
	public boolean createResource(Resource resource) throws Exception {
	dao.createResource(resource);
		return true;
	}

	@Override
	public List<Resource> listResource() throws Exception {
		
		return dao.listResource();
	}

	
	@Override
	public boolean updateResource(Resource resource) throws Exception {
		dao.updateResource(resource);
		return true;
	}

	@Override
	public Resource getResource(Resource resource) throws Exception {
		return dao.getResource(resource);
		
	}

	@Override
	public boolean deleteResource(Resource resource) throws Exception {
		return dao.deleteResource(resource);
		
	}


}
