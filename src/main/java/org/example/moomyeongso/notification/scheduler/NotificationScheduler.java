package org.example.moomyeongso.notification.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.moomyeongso.metrics.dto.TodayMetricsDto;
import org.example.moomyeongso.metrics.service.MetricsService;
import org.example.moomyeongso.notification.discord.dto.DiscordTextDto;
import org.example.moomyeongso.notification.discord.formatter.MetricsDiscordFormatter;
import org.example.moomyeongso.notification.discord.service.DiscordNotifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationScheduler {

    private final MetricsService metricsService;
    private final MetricsDiscordFormatter metricsDiscordFormatter;
    private final DiscordNotifier discordNotifier;

//    @Scheduled(cron = "0 0 23 * * *")
//    public void sendDailyMetricsReport() {
//        TodayMetricsDto metrics = metricsService.getTodayMetrics();
//        DiscordEmbedDto embed = metricsDiscordFormatter.toDiscordEmbed(metrics);
//        discordNotifier.sendEmbed(embed);
//        log.info("Metrics report sent to Discord: {}", embed);
//    }

    @Scheduled(cron = "0 0 23 * * *")
    public void sendDailyMetricsReport() {
        TodayMetricsDto metrics = metricsService.getTodayMetrics();
        DiscordTextDto texts = metricsDiscordFormatter.toDiscordText(metrics);
        discordNotifier.sendText(texts);
        log.info("Metrics report sent to Discord: {}", texts);
    }
}
