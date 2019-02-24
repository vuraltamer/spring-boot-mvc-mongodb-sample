package com.usermanagement.controller.base;

import java.util.ArrayList;
import java.util.List;

import com.usermanagement.controller.dto.base.BaseDto;
import com.usermanagement.dao.entity.base.BaseEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.usermanagement.util.constant.Constants.ERR_DATA_NOT_FOUND;

@Component
public abstract class BaseController<T extends BaseEntity, S extends BaseDto> extends ResponseMessages{
	
	@Autowired
	public Mapper mapper; 


	/*
	* Convert Response Object
	* Entity to DTO
	*
	* */
	public ResponseEntity<BaseDto> createResponse(T entity, S resource) {
		try {
			if (entity == null) {
				return new ResponseEntity<BaseDto>(responseMesagge(ERR_DATA_NOT_FOUND), HttpStatus.NO_CONTENT);
			}
			return ResponseEntity.ok(mapper.map(entity, resource.getClass()));

		} catch (Exception e) {
			return new ResponseEntity<BaseDto>(HttpStatus.BAD_GATEWAY);
		}
	}

	/*
	 * Convert Response Object
	 * List<Entity> to List<DTO>
	 *
	 * */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<BaseDto>> createResponse(List<T> entities, S resource) {
		try {
			
			List<BaseDto> resources = new ArrayList<>();
			for (T t : entities) {
				resources.add(mapper.map(t,resource.getClass()));
			}
			
			return ResponseEntity.ok(resources);
			
		} catch (Exception e) {
			return new ResponseEntity<List<BaseDto>>(HttpStatus.BAD_GATEWAY);
		}
	}

	/*
	 * Convert Request Object
	 * DTO to Entity
	 *
	 * */
	public BaseEntity createRequest(T entity, S resource) {
		try {
			return mapper.map(resource, entity.getClass());
		} catch (Exception e) {
			return null;
		}
	}
	
}