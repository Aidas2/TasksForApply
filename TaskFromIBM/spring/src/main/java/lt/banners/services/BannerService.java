package lt.banners.services;

import java.util.List;
import java.util.stream.Collectors;

import lt.banners.dto.CreateBannerDTO;
import lt.banners.dto.ReturnBannerDTO;
import lt.banners.entities.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.banners.repositories.BannerRepository;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public BannerService(
            BannerRepository bannerRepository) {
        super();
        this.bannerRepository = bannerRepository;
    }

    //GET ALL ------------------------------------------------------------
    @Transactional(readOnly = true)
    public List<ReturnBannerDTO> getAllBanners() {
        return bannerRepository.findAll()
                .stream()
                .map((b) -> new ReturnBannerDTO(
                        b.getId(),
                        b.getTitleOfChannel(),
                        b.getTitleOfShow(),
                        b.getShowingTime()
                ))
                .collect(Collectors.toList());
    }

    //GET BY TITLE ------------------------------------------------------------
    @Transactional(readOnly = true)
    public ReturnBannerDTO findBannerByTitle(String title) {
        Banner currentBanner = bannerRepository.findBannerByTitleOfChannel(title);
        return new ReturnBannerDTO(
                currentBanner.getId(),
                currentBanner.getTitleOfChannel(),
                currentBanner.getTitleOfShow(),
                currentBanner.getShowingTime());
    }

    //CREATE ------------------------------------------------------------
    @Transactional
    public void createBanner(CreateBannerDTO createBannerDTO) {

        Banner newBanner = new Banner(
                createBannerDTO.getTitleOfChannel(),
                createBannerDTO.getTitleOfShow(),
                createBannerDTO.getShowingTime());
        bannerRepository.save(newBanner);

        bannerRepository.save(newBanner);
    }

    //UPDATE ------------------------------------------------------------
    @Transactional
    public void updateBanner(String title, CreateBannerDTO createBannerDTO) {
        Banner bannerToUpdate = bannerRepository.findBannerByTitleOfChannel(title);

        bannerToUpdate.setTitleOfChannel(createBannerDTO.getTitleOfChannel());
        bannerToUpdate.setTitleOfShow(createBannerDTO.getTitleOfShow());
        bannerToUpdate.setShowingTime(createBannerDTO.getShowingTime());

        bannerRepository.save(bannerToUpdate);
    }

    // DELETE ------------------------------------------------------------
    @Transactional
    public void deleteBanner(String title) {
        bannerRepository.deleteBannerByTitleOfChannel(title);
    }


}
