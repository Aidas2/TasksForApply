package lt.banners.entities;


import lt.banners.enums.Channel;

import java.time.LocalTime;


import javax.persistence.*;

@Entity
@Table (name = "Banners")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column //(name="title", unique=true, nullable=false)
    private Channel titleOfChannel;

    @Column
    private String titleOfShow;

    @Column
    private LocalTime showingTime;

    public Banner() {
    }

    public Banner(
            //Long id,
            Channel titleOfChannel, String titleOfShow, LocalTime showingTime) {
        //this.id = id;
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

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", titleOfChannel='" + titleOfChannel + '\'' +
                ", titleOfShow='" + titleOfShow + '\'' +
                ", showingTime=" + showingTime +
                '}';
    }
}
