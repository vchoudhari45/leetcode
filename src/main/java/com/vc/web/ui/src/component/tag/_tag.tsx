import { Tag } from "../../model/Tag"
import Link from "next/link"
import { generateTagUrl } from "../../util/urlUtil"

interface _TagProps {
    tag: Tag
    category: string
}
const _Tag = ({ tag, category }: _TagProps) => {
    const url = generateTagUrl(category, tag.title, false)
    return (
        <div className="mb-8 mt-1">
            <Link href={url} prefetch={false}>
                <a className="text-base md:text-lg capitalize leading-relaxed tracking-wide font-medium no-underline hover:underline">{tag.title}</a>
            </Link>
            <div className="text-sm md:text-base text-gray-900 leading-snug">{tag.description}</div>
            <Link href={url} prefetch={false}> 
                <a className="flex justify-start items-baseline tracking-tight text-xs md:text-sm text-gray-700 mt-2 no-underline hover:underline">
                    See Problem Set...
                </a>
            </Link>
        </div>
    )
}

export default _Tag