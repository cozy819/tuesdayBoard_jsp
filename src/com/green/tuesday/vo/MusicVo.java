package com.green.tuesday.vo;

public class MusicVo {
	
	// Fields
	private int songNum;
    private String genreId;
    private String title;
    private String linkAddress;
    private String albumName;
    private String songName;
    private String singer;
    private String lyrics;
    private String registerDate;
	
    // Constructor
    public MusicVo() {}
	public MusicVo(int songNum, String genreId, String title, String linkAddress, String albumName, String songName,
			String singer, String lyrics, String registerDate) {
		this.songNum = songNum;
		this.genreId = genreId;
		this.title = title;
		this.linkAddress = linkAddress;
		this.albumName = albumName;
		this.songName = songName;
		this.singer = singer;
		this.lyrics = lyrics;
		this.registerDate = registerDate;
	}
	
	// Getter
	public int getSongNum() {
		return songNum;
	}
	public String getGenreId() {
		return genreId;
	}
	public String getTitle() {
		return title;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public String getAlbumName() {
		return albumName;
	}
	public String getSongName() {
		return songName;
	}
	public String getSinger() {
		return singer;
	}
	public String getLyrics() {
		return lyrics;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	
	// Setter
	public void setSongNum(int songNum) {
		this.songNum = songNum;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MusicVo [songNum=" + songNum + ", genreId=" + genreId + ", title=" + title + ", linkAddress="
				+ linkAddress + ", albumName=" + albumName + ", songName=" + songName + ", singer=" + singer
				+ ", lyrics=" + lyrics + ", registerDate=" + registerDate + "]";
	}
    
    
}
