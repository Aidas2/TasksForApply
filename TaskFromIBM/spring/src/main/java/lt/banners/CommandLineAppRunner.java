package lt.banners;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lt.banners.entities.Banner;
import lt.banners.enums.Channel;
import lt.banners.repositories.BannerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(CommandLineAppRunner.class);

    @Autowired
    private BannerRepository bannerRepository;

    public CommandLineAppRunner(
            BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.warn("Deleting all information from in-memory database");
        bannerRepository.deleteAllInBatch();

        LocalTime localTime = LocalTime.now();

        List<Banner> banners = Arrays.asList(
                new Banner(Channel.LTR_TELEVIZIJA, "Žinios. Sportas. Orai", (localTime.plusMinutes(19))),
                new Banner(Channel.LRT_KLASIKA, "Stilius", localTime.plusMinutes(23)),
                new Banner(Channel.LRT_LITUANICA, "Muzikos festivalis „Nida 2019“", localTime.minusMinutes(18)),
                new Banner(Channel.LRT_LT, "FIFA Moterų paaulio futbolo čempionatas", localTime.plusMinutes(14)),
                new Banner(Channel.LRT_OPUS, "LRT Opus šokių aikštelė", localTime.minusMinutes(11)),
                new Banner(Channel.LRT_PLIUS_HD, "Laukinės gamtos sekliai", localTime.plusMinutes(17)),
                new Banner(Channel.LRT_RADIJAS, "Dievo žodis. Kasdieniai skaitymai. (Kart.)", localTime.plusMinutes(5))
        );


        bannerRepository.saveAll(banners);
        logger.info("Creating new banners => {}", banners.toString());

    }
}
