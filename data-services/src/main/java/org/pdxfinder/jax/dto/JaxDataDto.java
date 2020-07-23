package org.pdxfinder.jax.dto;

import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.result.dto.CnaTsv;
import org.pdxfinder.result.dto.ExpressionTsv;
import org.pdxfinder.result.dto.MutationTsv;

import java.util.List;

public class JaxDataDto {

    private List<MutationTsv> mutationTsvs;
    private List<CnaTsv> cnaTsvs;
    private List<ExpressionTsv> expressionTsvs;
    private List<PdxDto> pdxDtos;

    public List<MutationTsv> getMutationTsvs() {
        return mutationTsvs;
    }

    public List<CnaTsv> getCnaTsvs() {
        return cnaTsvs;
    }

    public List<ExpressionTsv> getExpressionTsvs() {
        return expressionTsvs;
    }

    public List<PdxDto> getPdxDtos() {
        return pdxDtos;
    }

    public JaxDataDto setMutationTsvs(List<MutationTsv> mutationTsvs) {
        this.mutationTsvs = mutationTsvs;
        return this;
    }

    public JaxDataDto setCnaTsvs(List<CnaTsv> cnaTsvs) {
        this.cnaTsvs = cnaTsvs;
        return this;
    }

    public JaxDataDto setExpressionTsvs(List<ExpressionTsv> expressionTsvs) {
        this.expressionTsvs = expressionTsvs;
        return this;
    }

    public JaxDataDto setPdxDtos(List<PdxDto> pdxDtos) {
        this.pdxDtos = pdxDtos;
        return this;
    }

    public JaxDataDto build(){
        return this;
    }
}
