package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.Resource;
import com.model.Role;
import com.model.Status;
import com.service.AdminServiceImpl;
import com.service.ProjectManagerService;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/admin")
public class RestController {
	@Autowired
	private AdminServiceImpl service;
	
	@Autowired
	private ProjectManagerService pservice;
	
	final static Logger logger = Logger.getLogger(RestController.class);
	
	
	
	public RestController() {
		logger.warn("Resource controller created");
	}

		
	
	@RequestMapping(value="/resources", headers="Accept=application/json",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Resource> ResourceList() {
		logger.warn("Get Resource List : ");
		Status status=new Status();
		try 
		{
			 
			 
			 status.setCode(200);
			 status.setMessage("Resources list available");
			 List<Resource>list=new ArrayList<Resource>();
			 
			 
			 for (Resource resource : service.listResource()) {
				 	List<Role> roleList = new ArrayList<>();
				 	Resource r1=new Resource();
					r1.setResourceId(resource.getResourceId());
					r1.setResourceName(resource.getResourceName());
					r1.setResourceStatus(resource.getResourceStatus());
					if(resource.getRoles() != null )
					{
						for(Role role1 : resource.getRoles())
						{
							
							Role role = new Role();
							role.setRoleName(role1.getRoleName());
							role.setRoleType(role1.getRoleType());
							role.setStartDate(role1.getStartDate());
							role.setEndDate(role1.getEndDate());
							roleList.add(role);
							r1.setRoles(roleList);
						}
					}
					
					list.add(r1);
			}
			
			return list;
			
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting resources :"+" error :"+e);
			status.setCode(400);
			status.setMessage("Resources Not available");
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	@RequestMapping(value="/resources/{id}" ,headers="Accept=application/json",method=RequestMethod.GET)
	public Resource getResource(@PathVariable("id")Integer id)
	{
		logger.warn("Get resource id : "+id);
		Status status=new Status();
		try 
		{
		    Resource resource=new Resource();
		    resource.setResourceId(id);
		    status.setCode(200);
			status.setMessage("Resource available");
			System.out.println(  service.getResource(resource));
			Resource resource1=service.getResource(resource);
			Resource r1=new Resource();
			r1.setResourceId(resource1.getResourceId());
			r1.setResourceName(resource1.getResourceName());
			r1.setResourceStatus(resource1.getResourceStatus());
			/*Team t=resource1.getTeam();
			r1.setTeam(t);
			Role r= resource1.getRoles().;*/
			return r1;
		}
		catch (Exception e) 
		{
			logger.error("error occured while getting student with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("Resource Not available");
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="/delete/{resourceId}" ,headers="Accept=application/json",method=RequestMethod.DELETE)
	public Status deleteResource(@PathVariable("resourceId")Integer id)
	{
		System.out.println("deletestudent:controller called");
		logger.warn("delete resource id : "+id);
		Status status=new Status();
		
		try 
		{
			Resource resource=new Resource();
			resource.setResourceId(id);
			pservice.removeRoleFromResource(resource);
			System.out.println("hello");
			service.deleteResource(resource);
			status.setCode(200);
			status.setMessage("resource deleted succesfully");
			
		} 
		catch (Exception e) 
		{
			logger.error("error occured while deleting resource with id :"+id +" error :"+e);
			status.setCode(400);
			status.setMessage("resource not deleted");
			e.printStackTrace();
			
		}
		return status;
	}
	

	@RequestMapping(value="/create",method=RequestMethod.PUT,headers="Accept=application/json")
	public Status createResource(@RequestBody Resource resource)
	{
		//System.out.println("createstudent:controller called");
		logger.warn("create student : "+resource);
		Status status= new Status();
		
		try 
		{
			service.createResource(resource);
			status.setCode(200);
			status.setMessage("resource created succesfully");
		}
		catch (Exception e)
		{
			logger.error("error occured while creating resource with name :"+resource.getResourceName() +" error :"+e);
			status.setCode(400);
			status.setMessage("resource not created");
			e.printStackTrace();
		}
		return status;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,headers="Accept=application/json")
	public Status updateResource(@RequestBody Resource resource)
	{
		//System.out.println("updatestudent:controller called");
		logger.warn("update student : "+resource);
		Status status= new Status();
		
		try 
		{
			service.updateResource(resource);
			status.setCode(200);
			status.setMessage("resource updated succesfully");
		} 
		catch (Exception e)
		{
			logger.error("error occured while updating resource with id :"+resource.getResourceId()+" error :"+e);
			status.setCode(400);
			status.setMessage("resource not updated");
			e.printStackTrace();
		}
		return status;
	}
}
