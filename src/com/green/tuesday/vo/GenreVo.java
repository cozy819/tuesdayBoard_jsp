package com.green.tuesday.vo;

public class GenreVo {
	
	// Fields
	private String genreId;
	private String genreName;
	private int genreSeq;
	
	// Constructor
	public GenreVo() {}
	public GenreVo(String genreId, String genreName, int genreSeq) {
		this.genreId = genreId;
		this.genreName = genreName;
		this.genreSeq = genreSeq;
	}
	
	// Getter
	public String getGenreId() {
		return genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public int getGenreSeq() {
		return genreSeq;
	}
	
	// Setter
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public void setGenreSeq(int genreSeq) {
		this.genreSeq = genreSeq;
	}
	
	// toString
	@Override
	public String toString() {
		return "GenreVo [genreId=" + genreId + ", genreName=" + genreName + ", genreSeq=" + genreSeq + "]";
	}
		
}
