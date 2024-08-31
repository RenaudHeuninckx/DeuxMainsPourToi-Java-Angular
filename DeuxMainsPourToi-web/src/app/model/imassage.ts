export interface IMassage {
  id: number
  titre: string
  type: string
  descriptionCourte: string
  description: string
  duree: string
  prix: number
  image: string
  displayed: boolean
  rang: number
  comments: any[]
}
