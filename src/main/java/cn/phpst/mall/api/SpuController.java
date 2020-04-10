package cn.phpst.mall.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Positive;

import cn.phpst.mall.bo.PageCounter;
import cn.phpst.mall.util.CommonUtil;
import cn.phpst.mall.vo.PagingDozer;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.BaseEntity;
import cn.phpst.mall.model.Spu;
import cn.phpst.mall.service.SpuService;
import cn.phpst.mall.vo.SpuSimplifyVO;


@RestController
@RequestMapping("/spu")
public class SpuController extends BaseEntity {
    protected final SpuService spuService;

    public SpuController(SpuService spuService) {
        this.spuService = spuService;
    }

    @GetMapping("/id/{id}/detail")
    public Spu getById(@PathVariable @Positive Long id) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException(10001);
        }

        return spu;
    }

    @GetMapping("/last")
    public PagingDozer<Spu,SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                        @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start,count);
        Page<Spu> page = this.spuService.getLatestPaging(pageCounter.getPage(),pageCounter.getCount());
        return new PagingDozer<>(page,SpuSimplifyVO.class);

    }
}
