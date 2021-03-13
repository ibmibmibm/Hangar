package io.papermc.hangar.model.common.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReviewState {
    UNREVIEWED("unreviewed", "Unreviewed"),

    REVIEWED("reviewed", "Reviewed"),

    UNDER_REVIEW("under_review", "Under Review"),

    BACKLOG("backlog", "Backlog"),

    PARTIALLY_REVIEWED("partially_reviewed", "Partially Reviewed");

    private final String apiName;
    private final String frontendName;

    ReviewState(String apiName, String frontendName) {
        this.apiName = apiName;
        this.frontendName = frontendName;
    }

    @Override
    @JsonValue
    public String toString() {
        return apiName;
    }

    public String getApiName() {
        return apiName;
    }

    public String getFrontendName() {
        return frontendName;
    }

    public boolean isChecked() {
        return this == ReviewState.REVIEWED || this == ReviewState.PARTIALLY_REVIEWED;
    }

    @JsonCreator
    public static ReviewState fromValue(String text) {
        for (ReviewState b : ReviewState.values()) {
            if (String.valueOf(b.apiName).equals(text)) {
                return b;
            }
        }
        return null;
    }

    private static final ReviewState[] VALUES = values();

    public static ReviewState[] getValues() {
        return VALUES;
    }
}
