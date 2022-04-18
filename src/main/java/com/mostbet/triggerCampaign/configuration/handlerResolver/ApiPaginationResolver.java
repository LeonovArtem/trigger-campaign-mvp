package com.mostbet.triggerCampaign.configuration.handlerResolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import org.springframework.data.domain.Pageable;

import java.util.Objects;

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
        var end = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("_end")));
        var start = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("_start")));
        String order = String.valueOf(webRequest.getParameter("_order"));
        String sort = String.valueOf(webRequest.getParameter("_sort"));
        int pageSize = end - start;
        int page = start / pageSize;

        return PageRequest.of(
                page,
                pageSize,
                Sort.by(Sort.Direction.valueOf(order), sort)
        );
    }
}

