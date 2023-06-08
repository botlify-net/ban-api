package net.botlify.ban.api.param;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Builder(setterPrefix = "with")
@EqualsAndHashCode
@ToString
public class SearchAddressParam {

  @Nullable
  @Getter
  private final Integer limit;

  @Nullable
  @Getter
  private final Boolean autoComplete;

  @Nullable
  @Getter
  private final Position position;

  @Nullable
  @Getter
  private final String postCode;

  @Nullable
  @Getter
  private final Type type;

  @AllArgsConstructor
  @ToString
  @EqualsAndHashCode
  public static class Position {

    @Getter
    private final long latitude;

    @Getter
    private final long longitude;

  }

  public static enum Type {

    STREET,

    CITY_CODE;

    public @NotNull String toBanParam() {
      return (switch(this) {
        case STREET -> "street";
        case CITY_CODE -> "citycode";
      });
    }

  }

}
