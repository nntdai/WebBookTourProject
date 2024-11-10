package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.DiadiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/diadiem")
public class DiadiemRestcontroller {
    @Autowired
    DiadiemService diaDiemService;

    @GetMapping
    public Page<DiadiemDto> listDiaDiem(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size, Model model)
    {
        return diaDiemService.getDiaDiems(page,size);

    }
    @PostMapping("/delete")
    public String deleteDiaDiem(@RequestBody int id)
    {
        diaDiemService.deleteDiaDiem(id);
        return "Xóa thành công ";
    }

    @PostMapping("/add")
    public Diadiem addDiadiem(@RequestBody DiadiemDto diadiemDto) {
        Diadiem diadiemE = new Diadiem();
        Vungmien vungMienE = new Vungmien();
        vungMienE.setId(diadiemDto.getIdVungMien().getId());
        diadiemE.setTen(diadiemDto.getTen());
        diadiemE.setIdVungMien(vungMienE);
        return diaDiemService.saveDiaDiem(diadiemE);  // Gọi service lưu địa điểm

    }

}
