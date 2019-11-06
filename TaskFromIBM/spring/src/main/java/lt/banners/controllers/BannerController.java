package lt.banners.controllers;

import java.util.List;

import lt.banners.dto.ReturnBannerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.banners.dto.CreateBannerDTO;
import lt.banners.services.BannerService;

@RestController
@Api(value = "banners")
@RequestMapping(value = "api/banners")
public class BannerController {

	private BannerService bannerService;

	@Autowired
	public BannerController(BannerService bannerService) {
		super();
		this.bannerService = bannerService;
	}
	
    //READ ------------------------------------------------------------
    @GetMapping
    @ApiOperation(value = "Get all banners", notes="Returns all banners")
    public List<ReturnBannerDTO> getBannerList() {
    	return bannerService.getAllBanners();
    } 
    
    //READ BY TITLE ------------------------------------------------------------
    @GetMapping("/{title}")
    @ApiOperation(value = "Get banner info", notes="Returns banner info")
    public ReturnBannerDTO getBannerByTitle(
    		@ApiParam(value = "Banner title", required = true)
            /*@Valid*/
            @PathVariable final String title) {
    	return bannerService.findBannerByTitle(title);
    }
    
    //CREATE ------------------------------------------------------------
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new banner", notes="Creates new banner")
	public void createBanner(
			@ApiParam(value = "Banner data", required = true)
            /*@Valid*/
            @RequestBody final CreateBannerDTO createBannerDTO) {
    	bannerService.createBanner(createBannerDTO);
    }
	   
    //DELETE ------------------------------------------------------------
    @DeleteMapping("/delete/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete banner", notes="Deletes selected banner")
    public void deleteBanner(
            @ApiParam(value = "Banner title", required = true)
            @PathVariable final String title) {
    	bannerService.deleteBanner(title);
    }

    //UPDATE ------------------------------------------------------------
    @PutMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update banner info", notes="Updates banner by title")
	public void updateBanner(
			@ApiParam(value = "Banner data", required = true)
            /*@Valid*/
            @RequestBody CreateBannerDTO createBannerDTO,
			@ApiParam(value = "Banner title", required = true)
            @PathVariable final String title) {
    	bannerService.updateBanner(title, createBannerDTO);
    }

}