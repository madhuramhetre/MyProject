package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ResourceDao;
import com.model.Resource;
@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public boolean createResource(Resource resource) throws Exception {
		resourceDao.createResource(resource);
		return true;
	}

	@Override
	public List<Resource> listResource() throws Exception {
		
		return resourceDao.listResource();
	}

	@Override
	public Resource getResource(Resource resource) throws Exception {
		
		return resourceDao.getResource(resource);
	}

	@Override
	public boolean deleteResource(Resource resource) throws Exception {
		resourceDao.deleteResource(resource);
		return true;
	}

	@Override
	public boolean updateResource(Resource resource) throws Exception {
		
		resourceDao.updateResource(resource);
		return true;
	}

	
	
}
