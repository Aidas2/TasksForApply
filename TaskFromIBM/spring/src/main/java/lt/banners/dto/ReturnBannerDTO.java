package lt.banners.dto;

import java.time.LocalTime;

import lt.banners.enums.Channel;

public class ReturnBannerDTO {
	
	private Long id;
	private Channel titleOfChannel;
	private String titleOfShow;
	private LocalTime showingTime;

	public ReturnBannerDTO() {
	}

	public ReturnBannerDTO(Long id, Channel titleOfChannel, String titleOfShow, LocalTime showingTime) {
		this.id = id;
		this.titleOfChannel = titleOfChannel;
		this.titleOfShow = titleOfShow;
		this.showingTime = showingTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Channel getTitleOfChannel() {
		return titleOfChannel;
	}

	public void setTitleOfChannel(Channel titleOfChannel) {
		this.titleOfChannel = titleOfChannel;
	}

	public String getTitleOfShow() {
		return titleOfShow;
	}

	public void setTitleOfShow(String titleOfShow) {
		this.titleOfShow = titleOfShow;
	}

	public LocalTime getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(LocalTime showingTime) {
		this.showingTime = showingTime;
	}
}
