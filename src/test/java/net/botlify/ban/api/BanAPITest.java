package net.botlify.ban.api;

import net.botlify.ban.api.param.SearchAddressParam;
import net.botlify.ban.api.result.SearchResultAddress;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BanAPITest {

  @Test
  public void searchAddress() throws IOException {
    final BanAPI banApi = new BanAPI();
    final SearchResultAddress result = banApi.searchAddress("8 bd du port");
    System.out.println(result);

    final SearchAddressParam param = SearchAddressParam.builder()
            .withAutoComplete(true)
            .build();
    final SearchResultAddress result2 = banApi.searchAddress("8 bd du port", param);
    System.out.println(result2);
  }

  @Test
  public void testReverse() throws IOException {
    final BanAPI banApi = new BanAPI();
    final SearchResultAddress result = banApi.reverse(48.86471, 2.34901);
    System.out.println(result);
  }

}