package com.nbeverton.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.nbeverton.dao.DocumentDAO;
import com.nbeverton.entity.Document;
import com.nbeverton.util.ErroSystem;
@ManagedBean
@SessionScoped
public class DocumentBean {

	
	private Document document = new Document();
	private List<Document> documentList = new ArrayList<>();
	private DocumentDAO documentDao = new DocumentDAO();
	
	public void addDocument() throws ErroSystem{
		documentList.add(document);
		documentDao.save(document);
		document = new Document();
	}
	
	public void searchDocument() throws ErroSystem{
		documentList = documentDao.search();
	}
	
	public void edit(Document d) throws ErroSystem{
		document = d;
	}
	
	public void deleteDocument(Document d) throws ErroSystem {
		documentDao.delete(d.getId());
	}
	
	

//	Métodos getters and setters
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
}
