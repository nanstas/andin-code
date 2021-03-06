package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Post
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class PostEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
        val author: String,
        val content: String,
        val published: Long,
        val likedByMe: Boolean,
        val likes: Int = 0,
) {
    fun toDto() = Post(id, author, content, published, likedByMe, likes)

    companion object {
        fun fromDto(dto: Post) = PostEntity(dto.id, dto.author, dto.content, dto.published, dto.likedByMe, dto.likes)
    }
}