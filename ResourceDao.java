package com.dao;

import java.util.List;

import com.model.Resource;
public interface ResourceDao {
	public boolean createResource(Resource resource) throws Exception;
	public List<Resource> listResource()throws Exception;
	public Resource getResource(Resource resource)throws Exception;
	public boolean deleteResource(Resource resource)throws Exception;
	public boolean updateResource(Resource resource)throws Exception;
	
}
