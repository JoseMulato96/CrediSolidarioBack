package com.coomeva.credisolidario.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coomeva.credisolidario.dto.ParametrosBaseDTO;
import com.coomeva.credisolidario.service.ParametrosBaseService;
import com.coomeva.credisolidario.utilities.Constants;
import com.coomeva.credisolidario.utilities.ResponseService;
import com.coomeva.credisolidario.utilities.Status;

@RestController
@RequestMapping(value = "parametrosbase")
public class ParametrosBaseController {

	static final Logger logger = Logger.getLogger(ParametrosBaseController.class);

	@Autowired
	private ParametrosBaseService parametrosBaseService;

	@GetMapping()
	public ResponseEntity<ResponseService> get() {
		ResponseService response = new ResponseService();
		try {
			response.setData(parametrosBaseService.getAll());
			response.setStatus(Status.OK);
			return ResponseEntity.ok(response);
		}

		catch (Exception e) {
			logger.error(Constants.ERROR_SAVE, e);
			response.setStatus(Status.FAILURE);
			response.setMessageError(Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<ResponseService> post(@RequestBody ArrayList<ParametrosBaseDTO> items) {
		ResponseService response = new ResponseService();
		try {
			response.setData(parametrosBaseService.add(items));
			response.setStatus(Status.OK);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error(Constants.ERROR_SAVE, e);
			response.setStatus(Status.FAILURE);
			response.setMessageError(Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<ResponseService> put(@RequestBody List<ParametrosBaseDTO> items) {
		ResponseService response = new ResponseService();
		try {
			response.setData(parametrosBaseService.update(items));
			response.setStatus(Status.OK);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error(Constants.ERROR_SAVE, e);
			response.setStatus(Status.FAILURE);
			response.setMessageError(Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping()
	public ResponseEntity<ResponseService> delete(@RequestBody Long id) {
		ResponseService response = new ResponseService();
		try {
			parametrosBaseService.delete(id);
			response.setStatus(Status.OK);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error(Constants.ERROR_SAVE, e);
			response.setStatus(Status.FAILURE);
			response.setMessageError(Constants.ERROR_SAVE);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
