

export default function VideoDisplay({ video }) {
    return (
        <div className="video-display-container">
            {!video && <div className="spinner"></div>}
            {video && <video controls>
                <source src={video} type="video/mp4" />
                Your browser does not support the video tag.
            </video>}
        </div>
    );
}