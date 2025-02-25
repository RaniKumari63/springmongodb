package com.suchiit.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.model.TodoDTO;
import com.suchiit.repo.TodoRepo;

@RestController
public class TodoController {
	@Autowired
private TodoRepo todoRepo;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodos()
	{
		List<TodoDTO> tododata=todoRepo.findAll();
	  if(tododata.size()>0)
	  {
		  return new ResponseEntity<List<TodoDTO>>(tododata,HttpStatus.CREATED);
	  }
	  else
	  {
		  return new ResponseEntity<>("No todos available",HttpStatus.NOT_FOUND);
	  }

	
	}
	
	@PostMapping("/todos")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo  )
	{
		try
		{todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todo);
			return new ResponseEntity<TodoDTO>(todo,HttpStatus.OK);
		} catch(Exception ex)
		{
		return new 	ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<?>getSingleTodo(@PathVariable("id") String id)
	{
		
		Optional<TodoDTO> findById=todoRepo.findById(id);
		
		if(findById.isPresent())
		{
			System.out.println("jjjjjjjjjjjj");
			return new ResponseEntity<>(findById.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("todo not found with id"+id,HttpStatus.NOT_FOUND);
		}
		
	}
	
	

	
	
	
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<?>updateById(@PathVariable("id") String id,@RequestBody TodoDTO tododto)
	{ System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+id);
		TodoDTO todosave=null;
		Optional<TodoDTO> findById=todoRepo.findById(id);
		
		if(findById.isPresent())
		{System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+id);
			TodoDTO todoToSave=findById.get();
			
			
			BeanUtils.copyProperties(tododto, todoToSave);
			todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
		todosave=todoRepo.save(todoToSave);
		return new ResponseEntity<>(todoToSave,HttpStatus.OK);
		}
		else
		{System.out.println("ffffffffffffffffffffffrrr"+id);
			return new ResponseEntity<>("todo not found with id"+id,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<?>deleteById(@PathVariable("id") String id)
	{ System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+id);
		TodoDTO todosave=null;
		Optional<TodoDTO> findById=todoRepo.findById(id);
		
		if(findById.isPresent())
		{todoRepo.deleteById(id);
			
			
				
		return new ResponseEntity<>("successfully deleted by"+id,HttpStatus.OK);
		}
		else
		{System.out.println("ffffffffffffffffffffffrrr"+id);
			return new ResponseEntity<>("todo not found with id"+id,HttpStatus.NOT_FOUND);
		}
		
	}
	
		
		
		
		
	}
	
	
	
	
