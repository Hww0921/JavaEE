package it.hww.service;

import it.hww.controller.dto.CatalogueDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dkp
 * @create 2023-07-09 13:49
 */
@Service
public interface CatalogueService {
    List<CatalogueDTO> getCatalogueTree();
}
