package cn.phpst.mallexample.api;

import cn.phpst.mallexample.bo.PageCounter;
import cn.phpst.mallexample.exception.http.NotFoundException;
import cn.phpst.mallexample.model.Spu;
import cn.phpst.mallexample.service.SpuService;
import cn.phpst.mallexample.util.CommonUtil;
import cn.phpst.mallexample.vo.PagingDozer;
import cn.phpst.mallexample.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;


    @GetMapping("/id/{id}/detail")
    public Spu getById(@PathVariable @Positive Integer id) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException(10001);
        }

        return spu;
    }

    @GetMapping("/last")
    public PagingDozer<Spu,SpuSimplifyVO> getLatestSpuList(
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start,count);
        Page<Spu> page = this.spuService.getLatestPaging(pageCounter.getPage(),pageCounter.getCount());
        return new PagingDozer<>(page,SpuSimplifyVO.class);

    }
}
