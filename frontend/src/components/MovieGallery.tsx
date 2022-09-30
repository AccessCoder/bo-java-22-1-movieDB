import {Movie} from "../model/Movie";
import MovieCard from "./MovieCard";
import {FormEvent, useState} from "react";
import "./MovieGallery.css"


type MovieGalleryProps = {
    movies:Movie[]
    getAllMovies:() => void;
    postNewMovie:(newMovie:Movie) => void;
}

export default function MovieGallery(props:MovieGalleryProps){

    const [name, setName] = useState("");
    const [year, setYear] = useState("");
    const [poster, setPoster] = useState("");

    const onCreate = (e:FormEvent<HTMLFormElement>) => {

        e.preventDefault()
        if (!name || !year || !poster) {
            alert(`Please fill movie title, year and posterUrl`)
            return
        }

        const newMovie: Movie = {
            title: name,
            releaseYear: year,
            poster: poster
        }

        props.postNewMovie(newMovie)
    }

    return(
        <>
            <form onSubmit={(e) => onCreate(e)}>
                <input name={"title"} placeholder={"title"} onChange={event => setName(event.target.value)}/>
                <input name={"year"} placeholder={"year"} onChange={event => setYear(event.target.value)}/>
                <input name={"posterUrl"} placeholder={"posterUrl"} onChange={event => setPoster(event.target.value)}/>
                <button type={"submit"}> Confirm </button>
            </form>

            <div className={"cards"}>
            {props.movies.map((m) =>
                <div className={"card"}>
                <MovieCard movie={m}/>
                </div>)}
            </div>
        </>
    )
}