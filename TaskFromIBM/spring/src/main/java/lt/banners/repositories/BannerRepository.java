package lt.banners.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.banners.entities.Banner;

public interface BannerRepository extends JpaRepository <Banner, Long> {
	Banner findBannerByTitleOfChannel(String title);
	void deleteBannerByTitleOfChannel(String title);
}
