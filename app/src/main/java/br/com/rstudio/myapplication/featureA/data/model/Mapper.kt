package br.com.rstudio.myapplication.featureA.data.model

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel

class Mapper {

    fun transform(dto: ProductDTO) = ProductsModel(
        data = dto.data.map { transform(it) }
    )

    private fun transform(dto: ProductItemDTO) = ProductItemModel(
        id = dto.id,
        name = dto.name
    )

    fun transform(dto: ProductDetailsDTO) = ProductDetailsModel(
        id = dto.id,
        name = dto.name,
        type = dto.type
    )
}
