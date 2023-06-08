package net.botlify.ban.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.botlify.ban.api.param.SearchAddressParam;
import net.botlify.ban.api.result.SearchResultAddress;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Objects;

public class BanAPI {

  @NotNull
  private final OkHttpClient httpClient;

  private static final String API_URL = "https://api-adresse.data.gouv.fr";

  /**
   * Construct a ban api.
   */
  public BanAPI() {
    this.httpClient = new OkHttpClient();
  }

  public @NotNull SearchResultAddress searchAddress(@NotNull final String query)
      throws IOException {
    return searchAddress(query, null);
  }

  public @NotNull SearchResultAddress searchAddress(@NotNull final String query,
                                                    @Nullable final SearchAddressParam param)
      throws IOException {
    final HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(API_URL))
        .newBuilder()
        .encodedPath("/search/")
        .addEncodedQueryParameter("q", query);
    addParamToUrl(urlBuilder, param);

    // Send the request and return the result mapped.
    final Request request = new Request.Builder()
        .url(urlBuilder.build())
        .build();
    try (final Response response = httpClient.newCall(request).execute()) {
      final String body = response.body().string();
      final ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(body, SearchResultAddress.class);
    }
  }

  private void addParamToUrl(@NotNull final HttpUrl.Builder urlBuilder,
                             @Nullable final SearchAddressParam param) {
    if (param == null) {
      return;
    }
    if (param.getLimit() != null) {
      urlBuilder.addEncodedQueryParameter("limit", String.valueOf(param.getLimit()));
    }
    if (param.getAutoComplete() != null) {
      urlBuilder.addEncodedQueryParameter("autocomplete", String.valueOf(param.getAutoComplete()));
    }
    final SearchAddressParam.Position position = param.getPosition();
    if (position != null) {
      urlBuilder.addEncodedQueryParameter("lat", String.valueOf(position.getLatitude()));
      urlBuilder.addEncodedQueryParameter("lon", String.valueOf(position.getLongitude()));
    }
    if (param.getPostCode() != null) {
      urlBuilder.addEncodedQueryParameter("postcode", param.getPostCode());
    }
    if (param.getType() != null) {
      urlBuilder.addEncodedQueryParameter("type", param.getType().toBanParam());
    }

  }

}
