package net.botlify.ban.api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SearchResultAddress {

  @JsonProperty("type")
  @NotNull
  @Getter
  private String type;

  @JsonProperty("version")
  @NotNull
  @Getter
  private String version;

  @JsonProperty("features")
  @NotNull
  @Getter
  private List<Feature> features;

  @JsonProperty("attribution")
  @NotNull
  @Getter
  private String attribution;

  @JsonProperty("licence")
  @NotNull
  @Getter
  private String licence;

  @JsonProperty("query")
  @Nullable
  @Getter
  private String query;

  @JsonProperty("limit")
  @Getter
  private int limit;

  // Nested class representing the "Feature" object
  @ToString
  @EqualsAndHashCode
  @JsonIgnoreProperties(ignoreUnknown = true)
  @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
  public static class Feature {
    @JsonProperty("type")
    @NotNull
    @Getter
    private String type;

    @JsonProperty("geometry")
    @NotNull
    @Getter
    private Geometry geometry;

    @JsonProperty("properties")
    @NotNull
    @Getter
    private Properties properties;

    // Nested class representing the "Geometry" object
    @ToString
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    public static class Geometry {
      @JsonProperty("type")
      @NotNull
      @Getter
      private String type;

      @JsonProperty("coordinates")
      @NotNull
      @Getter
      private double[] coordinates;
    }

    // Nested class representing the "Properties" object
    @ToString
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    public static class Properties {
      @JsonProperty("label")
      @NotNull
      @Getter
      private String label;

      @JsonProperty("score")
      @Getter
      private double score;

      @JsonProperty("housenumber")
      @NotNull
      @Getter
      private String housenumber;

      @JsonProperty("id")
      @NotNull
      @Getter
      private String id;

      @JsonProperty("name")
      @NotNull
      @Getter
      private String name;

      @JsonProperty("postcode")
      @NotNull
      @Getter
      private String postcode;

      @JsonProperty("citycode")
      @NotNull
      @Getter
      private String citycode;

      @JsonProperty("x")
      @Getter
      private double x;

      @JsonProperty("y")
      @Getter
      private double y;

      @JsonProperty("city")
      @NotNull
      @Getter
      private String city;

      @JsonProperty("context")
      @NotNull
      @Getter
      private String context;

      @JsonProperty("importance")
      @Getter
      private double importance;

      @JsonProperty("street")
      @NotNull
      @Getter
      private String street;
    }

  }
}
