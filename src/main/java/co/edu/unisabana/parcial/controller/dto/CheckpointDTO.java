package co.edu.unisabana.parcial.controller.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckpointDTO {
  public String facility;
  public String driver;
  public int dayOfMonth;
}

