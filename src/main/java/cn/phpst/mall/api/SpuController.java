package cn.phpst.mall.api;

import cn.phpst.mall.bo.PageCounter;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.Spu;
import cn.phpst.mall.service.SpuService;
import cn.phpst.mall.util.CommonUtil;
import cn.phpst.mall.vo.PagingDozer;
import cn.phpst.mall.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
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
    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO getSimplifySpu(@PathVariable @Positive Integer id) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException(10001);
        }
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu,vo);
        return vo;
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
