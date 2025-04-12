

export default function VideoCreation({ imageUrl, onGeneration }) {
    return (
        <div className="create-video-container">
            <div className="create-video-textInput">
                <textarea placeholder="Enter text..."></textarea>
            </div>
            <div className="imageContainer">
                {!imageUrl && <div></div>}
                {imageUrl && <img src={`data:image/png;base64,${imageUrl}`} alt="Generated Image" />}
                <button onClick={onGeneration}>Generate video</button>
            </div>
        </div>
    );
}