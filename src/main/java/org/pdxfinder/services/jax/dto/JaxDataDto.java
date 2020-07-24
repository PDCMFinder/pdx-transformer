package org.pdxfinder.services.jax.dto;

import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.result.dto.CnaTsv;
import org.pdxfinder.services.result.dto.ExpressionTsv;
import org.pdxfinder.services.result.dto.MutationTsv;

import java.util.List;

public class JaxDataDto {

    private List<MutationTsv> mutationTsvs;
    private List<CnaTsv> cnaTsvs;
    private List<ExpressionTsv> expressionTsvs;
    private List<MetadataDto> metadataDtos;

    public List<MutationTsv> getMutationTsvs() {
        return mutationTsvs;
    }

    public List<CnaTsv> getCnaTsvs() {
        return cnaTsvs;
    }

    public List<ExpressionTsv> getExpressionTsvs() {
        return expressionTsvs;
    }

    public List<MetadataDto> getMetadataDtos() {
        return metadataDtos;
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

    public JaxDataDto setMetadataDtos(List<MetadataDto> metadataDtos) {
        this.metadataDtos = metadataDtos;
        return this;
    }

    public JaxDataDto build(){
        return this;
    }
}
