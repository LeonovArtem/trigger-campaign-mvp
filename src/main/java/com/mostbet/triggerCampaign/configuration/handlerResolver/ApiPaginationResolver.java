package com.mostbet.triggerCampaign.configuration.handlerResolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
public class ApiPaginationResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        var end = resolveEndParam(webRequest);
        var start = resolveStartParam(webRequest);
        var pageSize = end - start;
        var page = pageSize != 0 ? (start / pageSize) : 1;

        var optionalOrder = Optional.
                ofNullable(webRequest.getParameter("_order"))
                .map(String::valueOf);

        var optionalSort = Optional.
                ofNullable(webRequest.getParameter("_sort"))
                .map(String::valueOf);

        if (optionalOrder.isEmpty() && optionalSort.isEmpty()) {
            return PageRequest.of(page, pageSize);
        }

        return PageRequest.of(
                page,
                pageSize,
                Sort.by(
                        Sort.Direction.valueOf(optionalOrder.orElse("")),
                        optionalSort.orElse("")
                )
        );
    }

    private Integer resolveStartParam(NativeWebRequest webRequest) {
        var optional = Optional.
                ofNullable(webRequest.getParameter("_start"))
                .map(Integer::parseInt);

        return optional.orElse(1);
    }

    private Integer resolveEndParam(NativeWebRequest webRequest) {
        var optional = Optional.
                ofNullable(webRequest.getParameter("_end"))
                .map(Integer::parseInt);

        return optional.orElse(2);
    }
}

