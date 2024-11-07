package io.github.pandier.intellijdiscordrp.settings

import io.github.pandier.intellijdiscordrp.activity.ActivityDisplayMode
import io.github.pandier.intellijdiscordrp.activity.ActivityFactory

data class DiscordSettings(
    var reconnectOnUpdate: Boolean = true,
    var customApplicationIdEnabled: Boolean = false,
    var customApplicationId: String = "",
    var defaultDisplayMode: ActivityDisplayMode = ActivityDisplayMode.FILE,
    var focusTimeoutEnabled: Boolean = true,
    var focusTimeoutMinutes: Int = 20,
    var logoStyle: LogoStyleSetting = LogoStyleSetting.MODERN,

    var applicationDetails: String = "",
    var applicationState: String = "",
    var applicationLargeImage: ImageSetting = ImageSetting.APPLICATION,
    var applicationLargeImageEnabled: Boolean = true,
    var applicationLargeImageText: String = "{app_name}",
    var applicationSmallImage: ImageSetting = ImageSetting.APPLICATION,
    var applicationSmallImageEnabled: Boolean = false,
    var applicationSmallImageText: String = "",
    var applicationTimestampEnabled: Boolean = true,

    var projectDetails: String = "In {project_name}",
    var projectState: String = "",
    var projectLargeImage: ImageSetting = ImageSetting.APPLICATION,
    var projectLargeImageEnabled: Boolean = true,
    var projectLargeImageText: String = "{app_name}",
    var projectSmallImage: ImageSetting = ImageSetting.APPLICATION,
    var projectSmallImageEnabled: Boolean = false,
    var projectSmallImageText: String = "",
    var projectTimestampEnabled: Boolean = true,

    var fileDetails: String = "In {project_name}",
    var fileState: String = "Editing {file_name}",
    var fileLargeImage: ImageSetting = ImageSetting.FILE,
    var fileLargeImageEnabled: Boolean = true,
    var fileLargeImageText: String = "{file_type}",
    var fileSmallImage: ImageSetting = ImageSetting.APPLICATION,
    var fileSmallImageEnabled: Boolean = true,
    var fileSmallImageText: String = "{app_name}",
    var fileTimestampEnabled: Boolean = true,
) {
    val applicationActivityFactory: ActivityFactory
        get() = ActivityFactory(
            displayMode = ActivityDisplayMode.APPLICATION,
            logoStyle = logoStyle,
            details = applicationDetails,
            state = applicationState,
            largeImage = if (applicationLargeImageEnabled) applicationLargeImage else null,
            largeImageText = applicationLargeImageText,
            smallImage = if (applicationSmallImageEnabled) applicationSmallImage else null,
            smallImageText = applicationSmallImageText,
            timestampEnabled = applicationTimestampEnabled,
        )

    val projectActivityFactory: ActivityFactory
        get() = ActivityFactory(
            displayMode = ActivityDisplayMode.PROJECT,
            logoStyle = logoStyle,
            details = projectDetails,
            state = projectState,
            largeImage = if (projectLargeImageEnabled) projectLargeImage else null,
            largeImageText = projectLargeImageText,
            smallImage = if (projectSmallImageEnabled) projectSmallImage else null,
            smallImageText = projectSmallImageText,
            timestampEnabled = projectTimestampEnabled,
        )

    val fileActivityFactory: ActivityFactory
        get() = ActivityFactory(
            displayMode = ActivityDisplayMode.FILE,
            logoStyle = logoStyle,
            details = fileDetails,
            state = fileState,
            largeImage = if (fileLargeImageEnabled) fileLargeImage else null,
            largeImageText = fileLargeImageText,
            smallImage = if (fileSmallImageEnabled) fileSmallImage else null,
            smallImageText = fileSmallImageText,
            timestampEnabled = fileTimestampEnabled,
        )

    fun getActivityFactory(mode: ActivityDisplayMode) = when (mode) {
        ActivityDisplayMode.APPLICATION -> applicationActivityFactory
        ActivityDisplayMode.PROJECT -> projectActivityFactory
        ActivityDisplayMode.FILE -> fileActivityFactory
    }
}
