package lt.banners.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import lt.banners.enums.Channel;
import org.hibernate.validator.constraints.Length;

public class CreateBannerDTO {
	
	//private Long id;

	@NotNull
	private Channel titleOfChannel;

	@NotNull
	@Length(min = 1, max = 80)
	private String titleOfShow;

	@NotNull
	private LocalTime showingTime;

	public CreateBannerDTO() {
		
	}

    public CreateBannerDTO(
            //Long id,
            @NotNull Channel titleOfChannel, @NotNull @Length(min = 1, max = 80) String titleOfShow, @NotNull LocalTime showingTime) {
        //this.id = id;
        this.titleOfChannel = titleOfChannel;
        this.titleOfShow = titleOfShow;
        this.showingTime = showingTime;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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
