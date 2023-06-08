package net.botlify.ban.api;

import net.botlify.ban.api.result.SearchResultAddress;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BanAPITest {

  @Test
  public void searchAddress() throws IOException {
    final BanAPI banApi = new BanAPI();
    final SearchResultAddress result = banApi.searchAddress("8 bd du port");
    System.out.println(result);
  }
}